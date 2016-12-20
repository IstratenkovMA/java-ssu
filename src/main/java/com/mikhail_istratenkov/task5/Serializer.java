package com.mikhail_istratenkov.task5;

import java.io.*;

public class Serializer {

    private final File file;

    public Serializer(File file) {
        this.file = file;
    }

    public void serialize(Object object) throws SerializerException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(object);
        } catch (IOException e) {
            throw new SerializerException(e);
        }
    }

    public <T extends Serializable> T deserialize(Class<T> objectType) throws SerializerException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return objectType.cast(in.readObject());
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new SerializerException(e);
        }
    }
}
