package com.sise.asistencia_medica.common.application;

public interface iEntityDtoMapper<Entity, RequestDto, ResponseDto> {
    public Entity requestToEntity(RequestDto requestDto);
    public ResponseDto entityToResponse(Entity entity);
}
