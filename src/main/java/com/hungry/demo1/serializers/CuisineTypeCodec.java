package com.hungry.demo1.serializers;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import com.hungry.demo1.model.CuisineType;

public class CuisineTypeCodec implements Codec<CuisineType> {

	@Override
	public void encode(BsonWriter writer, CuisineType value, EncoderContext encoderContext) {
		writer.writeString(value.name());
	}

	@Override
	public Class<CuisineType> getEncoderClass() {
		return CuisineType.class;
	}

	@Override
	public CuisineType decode(BsonReader reader, DecoderContext decoderContext) {
		return CuisineType.fromDescription(reader.readString());
	}
}