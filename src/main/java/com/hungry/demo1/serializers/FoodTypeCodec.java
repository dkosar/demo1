package com.hungry.demo1.serializers;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import com.hungry.demo1.model.FoodType;

public class FoodTypeCodec implements Codec<FoodType> {

	@Override
	public void encode(BsonWriter writer, FoodType value, EncoderContext encoderContext) {
		writer.writeString(value.name());
	}

	@Override
	public Class<FoodType> getEncoderClass() {
		return FoodType.class;
	}

	@Override
	public FoodType decode(BsonReader reader, DecoderContext decoderContext) {
		return FoodType.fromDescription(reader.readString());
	}
}