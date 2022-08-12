package com.project.triple.service;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.entity.Package;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.PackageApiRequest;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.model.network.response.PackageApiResponse;
import com.project.triple.model.network.response.UserResponse.UsersApiResponse;
import com.project.triple.repository.PackageRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PackageApiLogicService extends BaseService<PackageApiRequest, PackageApiResponse, Package> {

    @Autowired
    private PackageRepository packageRepository;


    private PackageApiResponse response (Package package1) {
        PackageApiResponse packageApiResponse = PackageApiResponse.builder()
                .idx(package1.getIdx())
                .country(package1.getCountry())
                .title(package1.getTitle())
                .uploadPath(package1.getUploadPath())
                .fileName(package1.getFileName())
                .keyword(package1.getKeyword())
                .adultPr(package1.getAdultPr())
                .kidPr(package1.getKidPr())
                .infantPr(package1.getInfantPr())
                .adultInfantPr(package1.getAdultInfantPr())
                .program(package1.getProgram())
                .contained(package1.getContained())
                .notContained(package1.getNotContained())
                .adminuserId(package1.getAdminuserId())
                .adminuserName(package1.getAdminuserName())
                .regDate(package1.getRegDate())
                .build();
        return packageApiResponse;
    }

    @Override
    public Header<PackageApiResponse> create(Header<PackageApiRequest> request) {
        return null;
    }

    @Override
    public Header<PackageApiResponse> read(Long id) {
        return packageRepository.findById(id).map(aPackage -> response(aPackage)).map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PackageApiResponse> update(Header<PackageApiRequest> request) {
        return null;
    }

    @Override
    public Header<PackageApiResponse> delete(Long id) {
        return null;
    }

    public void write(Package package1, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        package1.setFileName(filename);
        package1.setUploadPath("/files/"+filename);
        packageRepository.save(package1);
    }

    public Header<List<PackageApiResponse>> sort_by_country(String country){

        List<PackageApiResponse> packageApiResponseList = packageRepository.findAllByCountry(country).stream().map(
                aPackage -> response(aPackage)
        ).collect(Collectors.toList());

        return Header.OK(packageApiResponseList);
    }

    public Header<List<PackageApiResponse>> sort_by_keyword(String keyword){

        List<PackageApiResponse> packageApiResponseList = packageRepository.findAllByKeyword(keyword).stream().map(aPackage -> response(aPackage))
                .collect(Collectors.toList());

        return Header.OK(packageApiResponseList);
    }

    public Header<List<PackageApiResponse>> sort_double(String country1, String country2){
        List<PackageApiResponse> packageApiResponseList = packageRepository.findAllByCountryOrCountry(country1, country2).stream().map(
                aPackage -> response(aPackage)
        ).collect(Collectors.toList());

        return Header.OK(packageApiResponseList);
    }

    /*패키지 조회*/
    public Header<List<PackageApiResponse>> search(){
        List<Package> packageList = packageRepository.findAllByOrderByIdxDesc();
        List<PackageApiResponse> packageApiResponseList = packageList.stream()
                .map(package1 -> response(package1))
                .collect(Collectors.toList());
        return Header.OK(packageApiResponseList);
    }
}
