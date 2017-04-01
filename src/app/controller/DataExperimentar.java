package app.controller;

import app.view.SimpleUi;

import java.io.File;

/**
 * Created by msrabon on 4/1/17.
 */
public class DataExperimentar {
    SimpleUi ui;
    File DataSet;

    public DataExperimentar(SimpleUi ui) {
        this.ui = ui;
        DataSet = ui.getDataSet();
    }
}
