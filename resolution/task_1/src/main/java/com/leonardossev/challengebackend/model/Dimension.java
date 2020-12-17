package com.leonardossev.challengebackend.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Dimension implements Serializable {

    private static final long serialVersionUID = -4519129216185439116L;

    private float weight;

    private float height;

    private float width;

    private float length;
}
