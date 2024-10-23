package jp.co.siam.restapi.entity;

import lombok.Data;

@Data
public class ZipCodeDataDto {
    String zipcode;
    String prefcode;
    String address1;
    String address2;
    String address3;
    String kana1;
    String kana2;
    String kana3;
}
