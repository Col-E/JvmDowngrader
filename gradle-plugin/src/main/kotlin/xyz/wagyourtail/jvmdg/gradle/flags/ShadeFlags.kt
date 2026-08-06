package xyz.wagyourtail.jvmdg.gradle.flags

import groovy.lang.Closure
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Optional
import java.io.Serializable

interface ShadeFlags: DowngradeFlags {

    /**
     *
     * @since 1.2.0
     */
    @get:Input
    @get:Optional
    val shadeInlining: Property<Boolean>

}
