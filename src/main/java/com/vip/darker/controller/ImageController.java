package com.vip.darker.controller;

import com.vip.darker.util.ConstantUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
 * @Description: 图片IO操作
 */
@RestController
@RequestMapping(value = "image")
public class ImageController {

    /**
     * 功能描述: 图片上传
     *
     * @param: [multipartRequest]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/8/8 11:53
     */
    @RequestMapping(value = "/uploadImage")
    public Map<String, Object> uploadImage(MultipartHttpServletRequest multipartRequest) throws IOException {
        // 设置返回值
        Map<String, Object> map = new HashMap<>();
        // 获取上传图片列表
        List<MultipartFile> myImageList = multipartRequest.getFiles("file_data");

        for (MultipartFile myImage : myImageList) {
            // 获取上传文件原始名称
            String oldImageName = myImage.getOriginalFilename();
            // 存储图片的虚拟本地路径
            String saveImagePath = ConstantUtil.PHOTO_PATH;
            // 上传图片
            if (oldImageName.length() > 0) {
                // 新图片名称
                String newImageName = UUID.randomUUID() + oldImageName.substring(oldImageName.indexOf("."));
                // 新图片
                File newImage = new File(saveImagePath + "\\" + newImageName);
                // 将内存中的数据写入磁盘
                myImage.transferTo(newImage);
                // 将新图片名称返回前端
                map.put(ConstantUtil.MSG, ConstantUtil.SUCCESS_UPLOAD);
                map.put("myImage", newImageName);
            } else {
                map.put(ConstantUtil.MSG, ConstantUtil.FAIL_UPLOAD);
            }
        }
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
    @RequestMapping(value = "/showImage/{imageName}", method = RequestMethod.GET)
    public void showImage(@PathVariable(value = "imageName") String imageName, HttpServletResponse response) {
        try {
            FileInputStream fis = new FileInputStream(ConstantUtil.PHOTO_PATH + "/" + imageName);
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
