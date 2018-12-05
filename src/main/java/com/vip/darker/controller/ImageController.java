package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.PhotoModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: Darker
 * @Date: 2018/8/7 23:02
 * @Description: 图片控制器
 */
@RestController
public class ImageController {

    /**
     * 功能描述: 图片新增
     *
     * @param: [photoModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:23
     */
    @RequestMapping(value = "/images", method = RequestMethod.POST)
    public Map<String, Object> addImage(PhotoModel photoModel) {

        boolean flag = SpringBootService.getPhotoService().insert(photoModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);

        return map;
    }

    /**
     * 功能描述: 图片更新
     *
     * @param: [photoModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:29
     */
    @RequestMapping(value = "/images", method = RequestMethod.PUT)
    public Map<String, Object> editImage(PhotoModel photoModel) {

        boolean flag = SpringBootService.getPhotoService().updateById(photoModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_UPDATE : Constant.FAIL_UPDATE);

        return map;
    }

    /**
     * 功能描述: 图片删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:37
     */
    @RequestMapping(value = "/images/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteImage(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getPhotoService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_DELETE : Constant.FAIL_DELETE);

        return map;
    }

    /**
     * 功能描述: 图片列表页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/2 22:56
     */
    @RequestMapping(value = "/images/page", method = RequestMethod.GET)
    public Map<String, Object> countImageMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getPhotoService().selectCount(new EntityWrapper<>());

        map.put("photoMaxPage", (count - 1) / (Constant.PAGE_SIZE + 2) + 1);

        return map;
    }

    /**
     * 功能描述: 图片对象查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.PhotoModel
     * @auther: darker
     * @date: 2018/8/2 22:57
     */
    @RequestMapping(value = "/images/{id}", method = RequestMethod.GET)
    public PhotoModel findImageById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getPhotoService().selectById(id);
    }

    /**
     * 功能描述: 图片列表查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.PhotoModel>
     * @auther: darker
     * @date: 2018/7/20 15:46
     */
    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public List<PhotoModel> findListImage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        return SpringBootService.getPhotoService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }


    /**
     * 功能描述: 图片上传
     *
     * @param: [multipartRequest]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/8 11:53
     */
    @RequestMapping(value = "/images/upload", method = RequestMethod.POST)
    public Map<String, Object> uploadImage(MultipartHttpServletRequest multipartRequest) {
        // 设置返回值
        Map<String, Object> map = new HashMap<>();
        // 获取上传图片列表
        List<MultipartFile> myImageList = multipartRequest.getFiles("file_data");

        myImageList.forEach(opt -> {
            try {
                // 获取上传文件原始名称
                String oldImageName = opt.getOriginalFilename();
                // 存储图片的虚拟本地路径
                String saveImagePath = Constant.PHOTO_PATH;
                // 上传图片
                if (oldImageName.length() > 0) {
                    // 新图片名称
                    String newImageName = UUID.randomUUID() + oldImageName.substring(oldImageName.indexOf("."));
                    // 新图片
                    File newImage = new File(saveImagePath + "\\" + newImageName);
                    // 将内存中的数据写入磁盘
                    opt.transferTo(newImage);
                    // 将新图片名称返回前端
                    map.put(Constant.MSG, Constant.SUCCESS_UPLOAD);
                    map.put("myImage", newImageName);
                } else {
                    map.put(Constant.MSG, Constant.FAIL_UPLOAD);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return map;
    }

    /**
     * 功能描述: 图片展示
     *
     * @param: [imageName, response]
     * @return: void
     * @auther: darker
     * @date: 2018/8/14 11:37
     */
    @RequestMapping(value = "/images/show/{imageName}", method = RequestMethod.GET)
    public void showImage(@PathVariable(value = "imageName") String imageName, HttpServletResponse response) {
        try {
            FileInputStream fis = new FileInputStream(Constant.PHOTO_PATH + "/" + imageName);
            // 获取文件大小
            int size = fis.available();
            // 设置读取字节数
            byte[] data = new byte[size];
            // 读取文件
            fis.read(data);
            // 设置返回文件类型
            response.setContentType("image/*");
            // 获取输出流
            OutputStream os = response.getOutputStream();
            // 输出数据
            os.write(data);
            // 将内存数据写入磁盘
            os.flush();
            // 关闭流
            os.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}