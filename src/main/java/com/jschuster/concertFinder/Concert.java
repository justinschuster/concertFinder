
package com.jschuster.concertFinder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Concert(String type, Value value) {
}
