package com.warisradji.processing_scala.get_started

import processing.core.PApplet

import scala.collection.mutable.ArrayBuffer

case class Ball(sketch: PApplet,
                x: Float,
                y: Float,
                size: Float,
                xSpeed: Float,
                ySpeed: Float) {
  def next: Ball = {
    val newX = x + xSpeed
    val newY = y + ySpeed

    Ball(sketch,
         newX,
         newY,
         size,
         if (newX < 0 || newX > sketch.width) -xSpeed else xSpeed,
         if (newY < 0 || newY > sketch.height) -ySpeed else ySpeed)
  }

  def render(): Unit = {
    sketch.fill(size, 127)
    sketch.ellipse(x, y, size, size)
  }
}

object ProcessingFunctionsFromNonSketchClass extends PApplet {
  private val balls: ArrayBuffer[Ball] = ArrayBuffer.empty[Ball]
  override def settings(): Unit = {
    size(500, 500)
    balls += Ball(this,
                  width / 2,
                  height / 2,
                  random(10, 100),
                  random(-10, 10),
                  random(-10, 10))
  }

  override def draw(): Unit = {
    background(255)
    balls.zipWithIndex.foreach {
      case (ball, i) =>
        balls.update(i, ball.next)
        balls(i).render()
    }
  }

  override def mouseClicked(): Unit =
    balls += Ball(this,
                  mouseX,
                  mouseY,
                  random(10, 100),
                  random(-10, 10),
                  random(-10, 10))

  def main(args: Array[String]): Unit = {
    val processingArgs = Array("ProcessingFunctionsFromNonSketchClass")
    PApplet.runSketch(processingArgs, this)
  }
}
