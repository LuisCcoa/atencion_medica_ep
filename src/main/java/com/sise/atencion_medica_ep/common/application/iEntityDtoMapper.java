package com.sise.atencion_medica_ep.common.application;

public interface iEntityDtoMapper<Entity, RequestDto, ResponseDto> {

    public Entity requestToEntity(RequestDto requestDto);
    public ResponseDto entityToResponse(Entity entity);
}
