package com.nikomu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nikomu")
@EnableAspectJAutoProxy
public class FileConfig {
}
