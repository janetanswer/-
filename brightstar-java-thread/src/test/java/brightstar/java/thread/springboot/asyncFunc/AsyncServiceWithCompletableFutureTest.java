package brightstar.java.thread.springboot.asyncFunc;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncServiceWithCompletableFutureTest {

	Logger logger = LoggerFactory.getLogger(AsyncServiceWithCompletableFutureTest.class);

	@Autowired
	AsyncServiceWithCompletableFuture asyncServiceWithCompletableFuture;

	@Test
	public void test() {
		List<CompletableFuture> cfList = Stream.of(1, 2, 3).map(v -> {
			return asyncServiceWithCompletableFuture.invoke(v);
		}).collect(Collectors.toList());

		StringBuilder sb = new StringBuilder();
		CompletableFuture rs = CompletableFuture.allOf(cfList.toArray(new CompletableFuture[cfList.size()]))
				.whenComplete((v, t) -> {
					cfList.forEach(cf -> {
						sb.append(cf.getNow(null)).append(",");
					});
				});
		
		try {
            rs.get(6, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		System.out.println("------------------------" + sb.toString());
	}
}
