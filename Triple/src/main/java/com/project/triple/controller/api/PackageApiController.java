package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Package;
import com.project.triple.model.network.request.PackageApiRequest;
import com.project.triple.model.network.response.PackageApiResponse;
import com.project.triple.service.PackageApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/package")    // http://localhost:9090/api/package  url 주소
@RequiredArgsConstructor
public class PackageApiController extends CrudController<PackageApiRequest, PackageApiResponse, Package> {

    @Autowired
    private PackageApiLogicService packageApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , Package package1, MultipartFile file) throws Exception
    {
        packageApiLogicService.write(package1, file);

        ScriptUtils.alert( response , "패키지 작성완료!");
        return new ModelAndView("/pages/admin/product/packge");
    }
}
