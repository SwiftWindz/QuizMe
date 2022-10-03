package controller;

import java.io.File;

/**
 * An action that deletes a deck file from the data folder
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class DeleteDeckAction implements Action {

    private String fileName;

    public DeleteDeckAction(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean execute() {
        File file = new File("data/" + fileName);
        return file.delete();
    }
    
}
