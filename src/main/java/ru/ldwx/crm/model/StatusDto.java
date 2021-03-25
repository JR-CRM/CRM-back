package ru.ldwx.crm.model;

import java.util.Objects;

public class StatusDto {
    private String code;
    private String name;

    public StatusDto(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDto statusDto = (StatusDto) o;
        return code == statusDto.code && Objects.equals(name, statusDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
