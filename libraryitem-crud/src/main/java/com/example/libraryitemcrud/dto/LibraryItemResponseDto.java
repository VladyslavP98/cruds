package com.example.libraryitemcrud.dto;

public class LibraryItemResponseDto {
    private Long id;
    private String code;
    private String itemType;
    private String state;

    public LibraryItemResponseDto() {}
    public LibraryItemResponseDto(Long id, String code, String itemType, String state) {
        this.id = id;
        this.code = code;
        this.itemType = itemType;
        this.state = state;
    }

    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getItemType() { return itemType; }
    public String getState() { return state; }
}
