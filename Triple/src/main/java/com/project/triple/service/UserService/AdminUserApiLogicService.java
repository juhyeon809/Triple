package com.project.triple.service.UserService;

import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.enumclass.AdminUserStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.UserRequest.AdminUserApiRequest;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.repository.AdminUserRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

    @Autowired
    private AdminUserRepository adminUserRepository;

    private AdminUserApiResponse response(AdminUser adminUser) {
        AdminUserApiResponse adminUserApiResponse = AdminUserApiResponse.builder()
                .idx(adminUser.getIdx())
                .userid(adminUser.getUserid())
                .userpw(adminUser.getUserpw())
                .name(adminUser.getName())
                .hp(adminUser.getHp())
                .department(adminUser.getDepartment())
                .email(adminUser.getEmail())
                .position(adminUser.getPosition())
                .regDate(adminUser.getRegDate())
                .build();
        return adminUserApiResponse;
    }

    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest adminUserApiRequest = request.getData();
        AdminUser adminUser = AdminUser.builder().userid(adminUserApiRequest.getUserid())
                .userpw(adminUserApiRequest.getUserpw())
                .name(adminUserApiRequest.getName())
                .hp(adminUserApiRequest.getHp())
                .department(adminUserApiRequest.getDepartment())
                .email(adminUserApiRequest.getEmail())
                .position(adminUserApiRequest.getPosition())
                .status(AdminUserStatus.REGISTERED)
                .regDate(adminUserApiRequest.getRegDate())
                .build();
        AdminUser newAdminUser = baseRepository.save(adminUser);
        return Header.OK(response(newAdminUser));
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        return baseRepository.findById(id).map(adminUser -> response(adminUser)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest adminUserApiRequest = request.getData();
        Optional<AdminUser> adminUser = baseRepository.findById(adminUserApiRequest.getIdx());

        return adminUser.map(
                        adminUser1 -> {
                            adminUser1.setUserid(adminUserApiRequest.getUserid());
                            adminUser1.setUserpw(adminUserApiRequest.getUserpw());
                            adminUser1.setName(adminUserApiRequest.getName());
                            adminUser1.setHp(adminUserApiRequest.getHp());
                            adminUser1.setDepartment(adminUserApiRequest.getDepartment());
                            adminUser1.setEmail(adminUserApiRequest.getEmail());
                            adminUser1.setPosition(adminUserApiRequest.getPosition());
                            return adminUser1;
                        }).map(adminUser1 -> baseRepository.save(adminUser1)).map(adminUser1 -> response(adminUser1)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<AdminUser> adminUser = baseRepository.findById(id);
        return adminUser.map(adminUser1 -> {
            baseRepository.delete(adminUser1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public Header<AdminUserApiResponse> admin_login(String userid, String userpw) {
        Optional<AdminUser> adminUser = adminUserRepository.findByUseridAndUserpw(userid, userpw);

        return adminUser.map(adminUser1 -> response(adminUser1)).map(Header::OK).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public int IdCheck(String userid) {
        int result = 1;

        if (adminUserRepository.findByUserid(userid).isEmpty()) {
            result = 0;
        }
        return result;
    }

    /*관리자 조회*/
    public Header<List<AdminUserApiResponse>> search(){
        List<AdminUser> adminUserList = adminUserRepository.findAllByOrderByIdxDesc();
        List<AdminUserApiResponse> adminUserApiResponseList = adminUserList.stream()
                .map(adminUser -> response(adminUser))
                .collect(Collectors.toList());
        return Header.OK(adminUserApiResponseList);
    }
}
