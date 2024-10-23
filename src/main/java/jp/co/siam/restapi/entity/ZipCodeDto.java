package jp.co.siam.restapi.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ZipCodeDto {
    /** ステータス */
    int status;

    /** メッセージ */
    String message;

    /** 郵便番号情報リスト */
    List<ZipCodeDataDto> results = new ArrayList<>();

}
