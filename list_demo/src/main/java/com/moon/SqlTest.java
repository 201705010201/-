package com.moon;

public class SqlTest {

    @Select("SELECT d.* FROM `department` d, `user` u WHERE d.id = u.dept_id AND u.id = #{userId}")
    @Results({ @Result(property = "id", column = "id"),
            @Result(property = "children", column = "id",
                    many = @Many(select = "so.sao.ucode.data.dao.DepartmentDao.selectByParentId", fetchType = FetchType.EAGER)) })
    List<Department> selectUserOu(Long userId);
}
