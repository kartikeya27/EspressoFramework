package com.test.news.annotations

/**
 * If test is marked with this annotation the application data will be cleared up before the test executed.
 */
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ClearData