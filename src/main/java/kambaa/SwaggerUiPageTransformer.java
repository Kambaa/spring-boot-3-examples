package kambaa;

import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.webmvc.ui.SwaggerIndexPageTransformer;
import org.springdoc.webmvc.ui.SwaggerIndexTransformer;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.resource.ResourceTransformerChain;
import org.springframework.web.servlet.resource.TransformedResource;

import java.io.*;
import java.util.stream.Collectors;

@Configuration
@ConditionalOnProperty("openapi-ui.customCssFile")
public class SwaggerUiPageTransformer extends SwaggerIndexPageTransformer {

    /**
     * Instantiates a new Swagger index transformer.
     *
     * @param swaggerUiConfig           the swagger ui config
     * @param swaggerUiOAuthProperties  the swagger ui o auth properties
     * @param swaggerUiConfigParameters the swagger ui config parameters
     * @param swaggerWelcomeCommon      the swagger welcome common
     * @param objectMapperProvider      the object mapper provider
     */
    public SwaggerUiPageTransformer(SwaggerUiConfigProperties swaggerUiConfig, SwaggerUiOAuthProperties swaggerUiOAuthProperties, SwaggerUiConfigParameters swaggerUiConfigParameters, SwaggerWelcomeCommon swaggerWelcomeCommon, ObjectMapperProvider objectMapperProvider) {
        super(swaggerUiConfig, swaggerUiOAuthProperties, swaggerUiConfigParameters, swaggerWelcomeCommon, objectMapperProvider);
    }

    @Override
    public Resource transform(HttpServletRequest request,
                              Resource resource,
                              ResourceTransformerChain transformer)
            throws IOException {
        if (resource.toString().contains("swagger-ui.css")) {
            final InputStream is = resource.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);

            final var fis = new FileInputStream(ResourceUtils.getFile("classpath:" + customCssFile));

            final InputStreamReader fisr = new InputStreamReader(fis);

            try (BufferedReader br = new BufferedReader(isr); BufferedReader br2 = new BufferedReader(fisr);) {
                final String css = br.lines().collect(Collectors.joining());
                final String darkCss = br2.lines().collect(Collectors.joining());

                StringBuilder sb = new StringBuilder();
                sb.append(css);
                sb.append(darkCss);
                final byte[] transformedContent = sb.toString().getBytes();
                return new TransformedResource(resource, transformedContent);
            } // AutoCloseable br > isr > fis
        }
        return super.transform(request, resource, transformer);
    }

    @Value("${openapi-ui.customCssFile}")
    private String customCssFile;

    @Bean
    @ConditionalOnProperty("openapi-ui.customCssFile")
    public SwaggerIndexTransformer swaggerIndexTransformer(
            SwaggerUiConfigProperties a,
            SwaggerUiOAuthProperties b,
            SwaggerUiConfigParameters c,
            SwaggerWelcomeCommon d, ObjectMapperProvider e) {
        return new SwaggerUiPageTransformer(a, b, c, d, e);
    }


}