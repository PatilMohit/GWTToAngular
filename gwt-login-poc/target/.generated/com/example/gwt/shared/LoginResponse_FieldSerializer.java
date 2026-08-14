package com.example.gwt.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LoginResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getMessage(com.example.gwt.shared.LoginResponse instance) /*-{
    return instance.@com.example.gwt.shared.LoginResponse::message;
  }-*/;
  
  private static native void setMessage(com.example.gwt.shared.LoginResponse instance, java.lang.String value) 
  /*-{
    instance.@com.example.gwt.shared.LoginResponse::message = value;
  }-*/;
  
  private static native boolean getSuccess(com.example.gwt.shared.LoginResponse instance) /*-{
    return instance.@com.example.gwt.shared.LoginResponse::success;
  }-*/;
  
  private static native void setSuccess(com.example.gwt.shared.LoginResponse instance, boolean value) 
  /*-{
    instance.@com.example.gwt.shared.LoginResponse::success = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.example.gwt.shared.LoginResponse instance) throws SerializationException {
    setMessage(instance, streamReader.readString());
    setSuccess(instance, streamReader.readBoolean());
    
  }
  
  public static com.example.gwt.shared.LoginResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.example.gwt.shared.LoginResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.example.gwt.shared.LoginResponse instance) throws SerializationException {
    streamWriter.writeString(getMessage(instance));
    streamWriter.writeBoolean(getSuccess(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.example.gwt.shared.LoginResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.example.gwt.shared.LoginResponse_FieldSerializer.deserialize(reader, (com.example.gwt.shared.LoginResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.example.gwt.shared.LoginResponse_FieldSerializer.serialize(writer, (com.example.gwt.shared.LoginResponse)object);
  }
  
}
