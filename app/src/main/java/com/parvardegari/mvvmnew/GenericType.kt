package com.parvardegari.mvvmnew

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class GenericType<T> {


    fun getGenericType(): Type = object: TypeToken<T>() {}.type
}