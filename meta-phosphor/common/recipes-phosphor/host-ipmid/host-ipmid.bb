SUMMARY = "Phosphor OpenBMC IPMI daemon"
DESCRIPTION = "Phosphor OpenBMC IPMI router and plugin libraries"
HOMEPAGE = "http://github.com/openbmc/phosphor-host-ipmid"
PR = "r1"

RRECOMMENDS_${PN} += "packagegroup-obmc-ipmid-providers-libs"

inherit autotools pkgconfig
inherit obmc-phosphor-license
inherit obmc-phosphor-sdbus-service

TARGET_CFLAGS   += "-fpic"

DEPENDS += "obmc-mapper"
DEPENDS += "autoconf-archive-native"
RDEPENDS_${PN}-dev += "obmc-mapper-dev"
RDEPENDS_${PN} += "clear-once"
RDEPENDS_${PN} += "network"
RDEPENDS_${PN} += "libmapper"
RRECOMMENDS_${PN} += "virtual-obmc-settings-mgmt"
SRC_URI += "git://github.com/openbmc/phosphor-host-ipmid"

SRCREV = "5600345375dc537216ccb13de06036798bcc9de0"

S = "${WORKDIR}/git"

FILES_${PN}_append = " ${libdir}/host-ipmid/lib*${SOLIBS}"
FILES_${PN}-dev_append = " ${libdir}/host-ipmid/lib*${SOLIBSDEV} ${libdir}/host-ipmid/*.la"

DBUS_SERVICE_${PN} += "org.openbmc.HostServices.service"
