// EjecutarRequest.java
package com.denvi;

import java.util.List;

public record EjecutarRequest(String codigo, List<String> entradas) {}