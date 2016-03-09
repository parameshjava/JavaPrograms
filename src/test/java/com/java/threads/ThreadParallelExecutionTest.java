package com.java.threads;

import org.junit.Test;

import junit.framework.TestCase;

public class ThreadParallelExecutionTest extends TestCase {

    @Test
    public void testExcetionTime() throws InterruptedException {
        long seqExeTIme = ThreadParallelExecution.sequentialExecution();
        long parExeTime = ThreadParallelExecution.parallelExecution();

        assertTrue(seqExeTIme > parExeTime);
    }

}
