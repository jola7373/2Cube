package com.twoCube.calendar.dto;

import com.twoCube.calendar.domain.Event;
import com.twoCube.gifts.domain.GiftFlower;
import com.twoCube.gifts.domain.GiftNote;
import com.twoCube.gifts.domain.GiftPolaroid;
import com.twoCube.gifts.domain.GiftVoicemail;
import com.twoCube.gifts.dto.EGiftType;
import com.twoCube.members.domain.Member;
import lombok.Builder;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class MonthResponse {

    LocalDate createdAt;
    EGiftType giftType;

    public static List<MonthResponse> listfrom(List<GiftFlower> giftFlowers, List<GiftPolaroid> giftPolaroids,
                                        List<GiftNote> giftNotes, List<GiftVoicemail> giftVoicemails, Member member) {

        List<MonthResponse> appendingData = new ArrayList<>();

        for (GiftPolaroid giftPolaroid : giftPolaroids){
            appendingData.add(MonthResponse.builder()
                    .createdAt(giftPolaroid.getCreatedAt().toLocalDate())
                    .giftType(EGiftType.polaroid).build());
        }

        for (GiftNote giftNote : giftNotes){
            appendingData.add(MonthResponse.builder()
                    .createdAt(giftNote.getCreatedAt().toLocalDate())
                    .giftType(EGiftType.note).build());
        }

        for (GiftVoicemail giftVoicemail : giftVoicemails){
            appendingData.add(MonthResponse.builder()
                    .createdAt(giftVoicemail.getCreatedAt().toLocalDate())
                    .giftType(EGiftType.voicemail).build());
        }

        for (GiftFlower giftFlower : giftFlowers){
            appendingData.add(MonthResponse.builder()
                    .createdAt(giftFlower.getCreatedAt().toLocalDate())
                    .giftType(EGiftType.flower).build());
        }
        return appendingData;
    }
}
