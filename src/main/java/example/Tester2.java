package example;


import static spark.Spark.before;
import static spark.Spark.get;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.*;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.*;
import java.util.regex.Pattern;

public class Tester2 {
	static final MetricRegistry metrics = new MetricRegistry();
	
	  private final static MemoryMXBean mxBean=null ;
	
	public static void main(String args[]) {
		final Map<String, Metric> gauges = new HashMap<String, Metric>();

Gauge totalInit =  new Gauge<Long>() {

	@Override
	public Long getValue() {
		return mxBean.getHeapMemoryUsage().getInit() +
                mxBean.getNonHeapMemoryUsage().getInit();
	}
};
System.out.println("-----------------");
		 System.out.println(totalInit);

	
		 }
	
}
