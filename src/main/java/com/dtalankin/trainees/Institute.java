/**
 *     22.12.2015
 *     Dmitry Talankin
 *     Lessons #6 Task #3
 */

package com.dtalankin.trainees;

import com.dtalankin.exceptions.TraineeException;

public class Institute {
    private String name;
    private String city;

    public Institute(String name, String city) throws TraineeException {
        setName(name);
        setCity(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TraineeException {
        if (name == null || name.isEmpty()) {
            throw new TraineeException(TraineeErrorCodes.INSTITUTENAME_IS_NULL.getDescription());
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws TraineeException {
        if (city == null || city.isEmpty()) {
            throw new TraineeException(TraineeErrorCodes.INSTITUTECITY_IS_NULL.getDescription());
        }
        this.city = city;
    }
}
