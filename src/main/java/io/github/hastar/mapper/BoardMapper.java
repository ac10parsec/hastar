package io.github.hastar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.github.hastar.VO.PostVO;

@Mapper
public interface BoardMapper {
	public List<PostVO> getAllData();
}
