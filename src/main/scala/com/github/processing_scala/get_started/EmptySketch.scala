package com.github.processing_scala.get_started

import processing.core.PApplet

object EmptySketch extends PApplet {
  def main(args: Array[String]): Unit = {
    val processingArgs = Array("EmptySketch")
    PApplet.runSketch(processingArgs, this)
  }
}
