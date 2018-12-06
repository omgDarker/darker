package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.ImageModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.Constant;
import com.vip.darker.util.ConvertAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @Auther: Darker
 * @Date: 2018/8/7 23:02
 * @Description: 图片控制器
 */
@RestController
public class ImageController {

    private Logger logger = LoggerFactory.getLogger(ImageController.class);

    /**
     * 功能描述: 图片新增
     *
     * @param: [ImageModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:23
     */
    @RequestMapping(value = "/images", method = RequestMethod.POST)
    public Map<String, Object> addImage(ImageModel imageModel) {

        boolean flag = SpringBootService.getImageService().insert(imageModel);

        Map<String, Object> map = new HashMap<>();

        map.put(Constant.MSG, flag ? Constant.SUCCESS_INSERT : Constant.FAIL_INSERT);

        return map;
    }

    /**
     * 功能描述: 图片更新
     *
     * @param: [ImageModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 15:29
     */
    @RequestMapping(value = "/images", method = RequestMethod.PUT)
    public Map<String, Object> editImage(ImageModel imageModel) {

        boolean flag = SpringBootService.getImageService().updateById(imageModel);

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

        boolean flag = SpringBootService.getImageService().deleteById(id);

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

        int count = SpringBootService.getImageService().selectCount(new EntityWrapper<>());

        map.put("imageMaxPage", (count - 1) / (Constant.PAGE_SIZE + 2) + 1);

        return map;
    }

    /**
     * 功能描述: 图片对象查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.ImageModel
     * @auther: darker
     * @date: 2018/8/2 22:57
     */
    @RequestMapping(value = "/images/{id}", method = RequestMethod.GET)
    public ImageModel findImageById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getImageService().selectById(id);
    }

    /**
     * 功能描述: 图片列表查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.ImageModel>
     * @auther: darker
     * @date: 2018/7/20 15:46
     */
    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public List<ImageModel> findListImage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "12") Integer pageSize) {
        return SpringBootService.getImageService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
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
                String saveImagePath = Constant.IMAGE_PATH;
                // 上传图片
                if (Objects.requireNonNull(oldImageName).length() > 0) {
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
            FileInputStream fis = new FileInputStream(Constant.IMAGE_PATH + "/" + imageName);
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
            logger.info("[系统找不到指定文件]:" + Constant.IMAGE_PATH + "/" + imageName);
        }
    }

    /**
     * 功能描述: 视觉冲击
     *
     * @param: [classify, column]
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/home/images/{classifyId}/{columnId}", method = RequestMethod.GET)
    public ModelAndView findimageByClassifyIdAndColumnId(@PathVariable(value = "classifyId") Integer classifyId, @PathVariable(value = "columnId", required = false) Integer columnId) {

        ModelAndView modelAndView = new ModelAndView("home/image");
        // 图片列表
        modelAndView.addObject("imageList", SpringBootService.getImageService().selectList(new EntityWrapper<ImageModel>().where("classifyId={0} ", classifyId).and("columnId={0}", columnId)));
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());
        // 栏目名称
        modelAndView.addObject("columnName", ConvertAttribute.getColumnMap().getOrDefault(columnId, "其他栏目"));

        return modelAndView;
    }

    /**
     * 功能描述: 视觉冲击
     *
     * @param: [classify]
     * @return: ModelAndView
     * @auther: darker
     * @date: 2018/9/4 11:33
     */
    @RequestMapping(value = "/home/images/{classifyId}", method = RequestMethod.GET)
    public ModelAndView findImageByClassifyId(@PathVariable(value = "classifyId") Integer classifyId) {

        ModelAndView modelAndView = new ModelAndView("home/image");
        // 图片列表
        modelAndView.addObject("imageList", SpringBootService.getImageService().selectList(new EntityWrapper<ImageModel>().where("classifyId={0} ", classifyId)));
        // 栏目列表
        modelAndView.addObject("columnList", ConvertAttribute.getColumnList());

        return modelAndView;
    }
}