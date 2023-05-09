package nnz.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.eello.nnz.common.dto.PageDTO;
import nnz.userservice.dto.BookmarkedNanumDTO;
import nnz.userservice.dto.NanumParticipantsDTO;
import nnz.userservice.dto.TokenDTO;
import nnz.userservice.dto.UserDTO;
import nnz.userservice.vo.FindPwdVO;
import nnz.userservice.vo.LoginVO;
import nnz.userservice.vo.UserJoinVO;
import nnz.userservice.vo.UserUpdateProfileVO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {

    UserDTO join(UserJoinVO vo) throws UnsupportedEncodingException, JsonProcessingException;
    boolean isExistByEmail(String email);
    boolean isExistByNickname(String nickname);
    TokenDTO login(LoginVO vo);
    void findPwd(FindPwdVO vo);
    List<BookmarkedNanumDTO> findBookmarkedNanum(Long userId);
    UserDTO info(Long userId);
    PageDTO receivedNanums(Long userId, Pageable pageable);
    PageDTO providedNanums(Long userId, Pageable pageable);
    NanumParticipantsDTO nanumParticipants(Long userId, Long nanumId);
    void updateProfile(Long userId, UserUpdateProfileVO vo, MultipartFile file) throws UnsupportedEncodingException;
}