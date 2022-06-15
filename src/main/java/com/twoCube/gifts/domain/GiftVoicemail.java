package com.twoCube.gifts.domain;

import com.twoCube.common.domain.BaseTimeEntity;
import com.twoCube.couple.domain.Couple;
import com.twoCube.members.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class GiftVoicemail extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String voicemail;

    private boolean userChecked;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "couple_id")
    private Couple couple;
}
