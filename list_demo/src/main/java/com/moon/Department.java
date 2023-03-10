package com.moon;

public class department {
    /**
     * 部门code
     */
    @NotBlank(groups = DataValidation.Isv.class)
    @Size(max = 100)
    @JsonView(View.SelectionsView.class)
    private String code;

    /**
     * 上级id
     */
    @JsonView(View.SelectionsView.class)
    private Long parentId;

    /**
     * 层级
     */
    @JsonView(View.SelectionsView.class)
    private Integer level;

    /**
     * 名称
     */
    @NotBlank
    @Pattern(groups = {
            DataValidation.Specific.class}, regexp = "^\\S.{0,98}\\S|\\S{1}$", message = "{data.validation.common.name.message}")
    @JsonView(View.SelectionsView.class)
    private String name;

    /**
     * 上级名称
     */
    @TableField(exist = false)
    @JsonView(View.PageView.class)
    private String parentName;

    /**
     * 部门类型
     */
    @NotNull
    @JsonView(View.SelectionsView.class)
    private DeptType deptType;

    /**
     * 子部门
     */
    @TableField(exist = false)
    @JsonView(View.PageMoreView.class)
    private List<Department> children;
}