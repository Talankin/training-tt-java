/**
 *     21.12.2015
 *     Dmitry Talankin
 *     Lessons #6 Task #2
 */

package com.dtalankin.trainees;

import com.dtalankin.exceptions.TraineeException;

import java.util.List;

public class Group {
    private String name;
    private List<Trainee> trainees;

    public Group(String name, List trainees) throws TraineeException {
        setName(name);
        setTrainees(trainees);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TraineeException {
        if (name == null || name.isEmpty()) {
            throw new TraineeException(TraineeErrorCodes.GROUPNAME_IS_NULL.getDescription());
        }
        this.name = name;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) throws TraineeException {
        if (trainees == null || trainees.isEmpty()) {
            throw new TraineeException(TraineeErrorCodes.GROUPTRAINEE_IS_NULL.getDescription());
        }
        this.trainees = trainees;
    }
}
