package com.kta.sample.listener;

import com.kta.sample.annotations.AppListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
This is a sample listener class with a dummy method that is expected to log data
 */

@AppListener
public class ChangeEventListener {

    private static final Logger log = LoggerFactory.getLogger(ChangeEventListener.class);

    public void onMessage(){}
    public void onEvent(){}
}
