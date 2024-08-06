package knu.kproject.controller;

import knu.kproject.entity.ProjectUser;
import knu.kproject.global.code.Api_Response;
import knu.kproject.global.code.ErrorCode;
import knu.kproject.global.code.SuccessCode;
import knu.kproject.repository.*;
import knu.kproject.util.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
@RequiredArgsConstructor
public class DBController {
    private final ProjectRepositroy projectRepositroy;
    private final ProjectUserRepository projectUserRepository;
    private final ScheduleRepository scheduleRepository;
    private final StackRepository stackRepository;
    private final UserRepository userRepository;
    private final UserStackRepository userStackRepository;
    private final UserToolRepository userToolRepository;
    private final WorkspaceRepository workspaceRepository;

    @PostMapping("/reset")
    public ResponseEntity<Api_Response<Object>> resetDataBase() {
        try {
            projectUserRepository.deleteAll();
            scheduleRepository.deleteAll();
            projectRepositroy.deleteAll();
            workspaceRepository.deleteAll();
            userStackRepository.deleteAll();
            stackRepository.deleteAll();
            userToolRepository.deleteAll();
            userRepository.deleteAll();

            return ApiResponseUtil.createSuccessResponse(
                    SuccessCode.DELETE_SUCCESS.getCode()
            );
        } catch (RuntimeException e) {
            return ApiResponseUtil.createErrorResponse(
                    ErrorCode.DELETE_ERROR.getMessage(),
                    ErrorCode.DELETE_ERROR.getStatus()
            );
        }
    }
}