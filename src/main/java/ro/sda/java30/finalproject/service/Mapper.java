package ro.sda.java30.finalproject.service;

public interface Mapper<E, D> {
    public E mapDtoToEntity(D dto);

    public D mapEntityToDto(E entity);
}
