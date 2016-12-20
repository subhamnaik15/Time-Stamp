package com.takeoffandroid.multiselectrecyclergridview;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Subham Kumar Naik Satyam Kumar Naik on 22/06/16.
 */
public class Benchmarker {
	private static ArrayList<Benchmark> mBenchmarks = new ArrayList<Benchmark>(5);
	
	public static void start(String label) {
		//Log.d("Benchmark", "Starting benchmark for: " + label);
		Benchmark b = new Benchmark();
		b.label = label;
		b.startTime = System.currentTimeMillis();
		mBenchmarks.add(b);
	}
	
	public static void stop(String label) {
		long endTime = System.currentTimeMillis();
		long startTime = -1;
		for(Benchmark b : mBenchmarks) {
			if(label.equals(b.label)) {
				startTime = b.startTime;
				mBenchmarks.remove(b);
				break;
			}
		}
		long elapsed = endTime - startTime;
		Log.e("Benchmark", label + " finished in " + elapsed + " ms.");
	}
	
	private static class Benchmark {
		long startTime;
		String label;
	}
}
