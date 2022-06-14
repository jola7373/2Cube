package com.twoCube.members.controller;


import com.twoCube.common.annotation.CurrentUser;
import com.twoCube.gifts.dto.FlowerRequest;
import com.twoCube.members.domain.Member;
import com.twoCube.members.dto.MemberInfoRequest;
import com.twoCube.members.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
@Api(tags = {"회원 API"})
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    @ApiOperation(value = "회원 정보 입력 api")
    public ResponseEntity<Long> saveMemberInfo(@RequestBody MemberInfoRequest memberInfoRequest,
                                               @ApiIgnore @CurrentUser Member member
    ) {
        System.out.println(member.getCouple());
        System.out.println(memberInfoRequest.getBirthDay());
        Long coupleId = memberService.updateMemberInfo(member, memberInfoRequest);
        return ResponseEntity.ok(coupleId);
    }

//    @PostMapping("")
//    @ApiOperation(value = "꽃 선물하기 api")
//    public ResponseEntity<Long> createFlower(@RequestBody FlowerRequest flowerRequest,
//                                             @ApiIgnore @CurrentUser Member member
//    ) {
//        Long giftFlowerId = giftFlowerService.createFlower(flowerRequest, member);
//        return ResponseEntity.ok(giftFlowerId);
//    }
}
