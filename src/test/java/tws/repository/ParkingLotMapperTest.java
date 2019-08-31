package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.ParkingLot;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {
    @Autowired
    private ParkingLotMapper parkingLotMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }

    @Test
    public void should_Fetch_All_ParkingLots() {
        // given
        jdbcTemplate.execute("insert  into parkinglot(parkingLotID,capacity) values('1',50)");
        // when
        List<ParkingLot> parkingLotList = parkingLotMapper.selectAll();
        // then
        assertEquals("1", parkingLotList.get(0).getParkingLotID());
    }
}
