/**
 *     06.11.2015
 *     Dmitry Talankin
 *     Lessons #5 Task #2
 */

package com.dtalankin.trainees;


import com.dtalankin.exceptions.TraineeException;

import java.io.Serializable;

public class Trainee implements Serializable, Comparable<Trainee>{
    private String firstName;
    private String lastName;
    private Integer rating;

    public Trainee(String firstName, String lastName, Integer rating) throws TraineeException {
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws TraineeException {
        if (firstName == null || firstName.isEmpty()) {
            throw new TraineeException(TraineeErrorCodes.FIRSTNAME_IS_NULL.getDescription());
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws TraineeException {
        if (lastName == null || lastName.isEmpty()) {
            throw new TraineeException(TraineeErrorCodes.LASTNAME_IS_NULL.getDescription());
        }
        this.lastName = lastName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) throws TraineeException {
        if (rating < 1 || rating > 5) {
            throw new TraineeException(TraineeErrorCodes.RATING_IS_INCORRECT.getDescription());
        }
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainee trainee = (Trainee) o;

        if (getRating() != trainee.getRating()) return false;
        if (getFirstName() != null ? !getFirstName().equals(trainee.getFirstName()) : trainee.getFirstName() != null)
            return false;
        return !(getLastName() != null ? !getLastName().equals(trainee.getLastName()) : trainee.getLastName() != null);

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getRating();
        return result;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Trainee o) {
        return rating.compareTo(o.rating);
    }
}
