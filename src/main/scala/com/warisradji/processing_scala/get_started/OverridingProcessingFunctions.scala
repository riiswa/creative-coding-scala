package com.warisradji.processing_scala.get_started

import processing.core.PApplet

object OverridingProcessingFunctions extends PApplet {
  override def settings(): Unit = size(500, 500)

  override def draw(): Unit = ellipse(mouseX, mouseY, 50, 50)

  override def mousePressed(): Unit = background(64)

  def main(args: Array[String]): Unit = {
    val processingArgs = Array("OverridingProcessingFunctions")
    PApplet.runSketch(processingArgs, this)
  }

}
