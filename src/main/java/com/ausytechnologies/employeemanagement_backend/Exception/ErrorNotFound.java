package com.ausytechnologies.employeemanagement_backend.Exception;

public class ErrorNotFound extends RuntimeException {

        public int id;
        public String message;

        public ErrorNotFound(){
            this.message = "Entities \" have not been found!\"";
        }
        public ErrorNotFound(int id){
            this.id = id;
            this.message = "Entity with \" + id + \" has not been found!\"";
        }



        @Override
        public String toString() {
            return "Entity with " + id + " has not been found!";
        }
}


