package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class App {

    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void init()
    {
        Logger log = LoggerFactory.getLogger(App.class);
        log.info("Java app started");
    }

    public String getStatus() {
        return "OK";
    }
    
    private int in = 0;
    private int out = 0;
    private BigDecimal pi = new BigDecimal(3.141592653589793238462643);

    // get amount of points inside the circle
    private int getIn() {
        return this.in;
    }
    // get amount of points outside the circle
    private int getOut() {
        return this.out;
    }

    private BigDecimal getPi() {
        return this.pi;
    }

    private double getRand() {
        Random rd = new Random();
        return rd.nextDouble();
    }

    private BigDecimal calcPi() {
        // multiply the result with 4 because the simulation was only
        BigDecimal piTmp = BigDecimal.valueOf(4.0 * ((double) this.getIn() / ((double) this.getIn() + (double) this.getOut())));
        return piTmp;
    }

    // calculation for n
    public BigDecimal calculatePiForN(int n) {
        for (int i = 0; i < n; i++) {
            // method getRand() provides random values
            double x = this.getRand();
            double y = this.getRand();
            if (x * x + y * y <= 1) {
            // point is inside the circle
            this.in++;
            } else {
            // point is outside the circle
            this.out++;
            }
        }
        // print results in the console
        return this.calcPi();
    }
}
