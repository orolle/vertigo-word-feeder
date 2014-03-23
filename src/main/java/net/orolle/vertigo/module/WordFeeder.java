package net.orolle.vertigo.module;

import java.util.Random;

import net.kuujo.vertigo.java.RichFeederVerticle;

import org.vertx.java.core.json.JsonObject;

public class WordFeeder extends RichFeederVerticle {
  private String[] words = new String[]{
      "foo", "bar", "baz", "foobar", "foobaz", "barfoo", "barbaz", "bazfoo", "bazbar"
  };
  private Random random = new Random();

  @Override
  protected void nextMessage() {
    String word = words[random.nextInt(words.length-1)];
    emit(new JsonObject().putString("word", word));
  }
}
