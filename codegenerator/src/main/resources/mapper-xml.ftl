<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dao.mapper.${table.className}Mapper">

    <select id="get${table.className}ById" resultType="${table.className}">
        select
        <#list table.columnList as column>
            <#if column_has_next>
                ${column.columnName} as ${column.columnName},         <!--${column.columnRemark}-->
            <#else>
                ${column.columnName} as ${column.columnName}          <!--${column.columnRemark}-->
            </#if>
        </#list>
        from ${table.tableName}
        <trim prefix="where" prefixOverrides="and | or">
            <if test="id != null">
                and id=${r"#{"}id}
            </if>
        </trim>
    </select>

    <select id="get${table.className}ListByMap" resultType="${table.className}"
            parameterType="java.util.Map">
            select
            <#list table.columnList as column>
                <#if column_has_next>
                ${column.columnName} as ${column.columnName},      <!--${column.columnRemark}-->
                <#else>
                ${column.columnName} as ${column.columnName}       <!--${column.columnRemark}-->
                </#if>
            </#list>
            from ${table.tableName}
        <trim prefix="where" prefixOverrides="and | or">
        <#list table.columnList as column>
            <#if column.columnType=="Integer" >
                <if test="${column.columnName} != null and (${column.columnName}!='' or ${column.columnName}==0)">
                    and ${column.columnName}=${r"#{"}${column.columnName}}
                </if>
            <#else>
                <if test="${column.columnName} != null and ${column.columnName}!=''">
                    and ${column.columnName}=${r"#{"}${column.columnName}}
                </if>
            </#if>
        </#list>
        </trim>
        order by creationDate desc
        <if test="beginPos != null and beginPos!='' and pageSize != null  and pageSize !='' ">
            limit ${r"#{"}beginPos},${r"#{"}pageSize}
        </if>
    </select>

    <select id="get${table.className}CountByMap" resultType="Integer" parameterType="java.util.Map">
        select count(*) from ${table.tableName}
        <trim prefix="where" prefixOverrides="and | or">
            <#list table.columnList as column>
                <#if column.columnType=="Integer" >
                    <if test="${column.columnName} != null and (${column.columnName}!='' or ${column.columnName}==0)">
                        and ${column.columnName}=${r"#{"}${column.columnName}}
                    </if>
                <#else>
                    <if test="${column.columnName} != null and ${column.columnName}!=''">
                        and ${column.columnName}=${r"#{"}${column.columnName}}
                    </if>
                </#if>
            </#list>
        </trim>
    </select>

    <insert id="save${table.className}" parameterType="${table.className}">
        insert into ${table.tableName}(
    <#list table.columnList as column>
        <#if column.columnName !="id">
            <#if column_has_next >
            ${column.columnName} ,      <!--${column.columnRemark}-->
            <#else>
            ${column.columnName}       <!--${column.columnRemark}-->
            </#if>
        </#if>
    </#list>
        )
        values(
            <#list table.columnList as column>
                <#if column.columnName !="id">
                    <#if column_has_next >
                    ${r"#{"}${column.columnName}} ,      <!--${column.columnRemark}-->
                    <#else>
                    ${r"#{"}${column.columnName}}       <!--${column.columnRemark}-->
                    </#if>
                </#if>
            </#list>
        )
    </insert>

    <update id="modify${table.className}" parameterType="${table.className}">
        update ${table.tableName}
        <trim prefix="set" suffixOverrides="," suffix="where id= ${r"#{"}id}">
        <#list table.columnList as column>
            <#if column.columnType=="Integer" >
                <if test="${column.columnName} != null and (${column.columnName}!='' or ${column.columnName}==0)">
                     ${column.columnName}=${r"#{"}${column.columnName}},
                </if>
            <#else>
                <if test="${column.columnName} != null and ${column.columnName}!=''">
                     ${column.columnName}=${r"#{"}${column.columnName}},
                </if>
            </#if>
        </#list>
        </trim>
    </update>

    <delete id="remove${table.className}ById" parameterType="Long">
        delete from ${table.tableName} where id = ${r"#{"}id}
    </delete>
</mapper>