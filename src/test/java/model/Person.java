package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private String value;
    @JsonProperty(value = "unrestricted_value")
    private String unrestrictedValue;

    private DataModel data;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnrestrictedValue() {
        return unrestrictedValue;
    }

    public void setUnrestrictedValue(String unrestrictedValue) {
        this.unrestrictedValue = unrestrictedValue;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }



    public static class DataModel {
        private String surname;
        private String name;
        private String patronymic;
        private String gender;
        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

}
