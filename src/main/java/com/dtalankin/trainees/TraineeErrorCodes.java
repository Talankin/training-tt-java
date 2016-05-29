/**
 *     06.11.2015
 *     Dmitry Talankin
 *     Lessons #5 Task #3
 */

package com.dtalankin.trainees;


public enum TraineeErrorCodes {
    FIRSTNAME_IS_NULL("Имя не может быть пустым"),
    LASTNAME_IS_NULL("Фамилия не может быть пустой"),
    RATING_IS_INCORRECT("Оценка должна быть целым числом в интервале 1..5"),
    GROUPNAME_IS_NULL("Имя группы не может быть пустым"),
    GROUPTRAINEE_IS_NULL("Массив Trainee не может быть пустым"),
    INSTITUTENAME_IS_NULL("Название института не может быть пустым"),
    INSTITUTECITY_IS_NULL("Название города не может быть пустым");

    private String description;

    TraineeErrorCodes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
