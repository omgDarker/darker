package com.vip.darker.io;

import com.vip.darker.util.Constant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
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
public class ImageHandler {

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
            String saveImagePath = Constant.PHOTO_PATH;
            // 上传图片
            if (oldImageName.length() > 0) {
                // 新图片名称
                String newImageName = UUID.randomUUID() + oldImageName.substring(oldImageName.indexOf("."));
                // 新图片
                File newImage = new File(saveImagePath + "\\" + newImageName);
                // 将内存中的数据写入磁盘
                myImage.transferTo(newImage);
                // 将新图片名称返回前端
                map.put(Constant.MSG, Constant.SUCCESS_UPLOAD);
                map.put("myImage", newImageName);
            } else {
                map.put(Constant.MSG, Constant.FAIL_UPLOAD);
            }
        }
        return map;
    }
}
